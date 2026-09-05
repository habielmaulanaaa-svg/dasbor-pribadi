# Dasbor Mobile Local Socket Server (No Admin, No Password, Pure .NET)
$port = 5500
$folder = $PSScriptRoot

# Ambil IP Lokal Wi-Fi / LAN
$localIp = (Get-NetIPAddress -AddressFamily IPv4 | Where-Object { $_.InterfaceAlias -notlike "*Loopback*" -and $_.IPAddress -notlike "169.254*" } | Select-Object -First 1).IPAddress
if (-not $localIp) { $localIp = "127.0.0.1" }

$listener = New-Object System.Net.Sockets.TcpListener ([System.Net.IPAddress]::Any, $port)

try {
    $listener.Start()
} catch {
    Write-Host "Gagal membuka port $port. Menutup proses lama..." -ForegroundColor Yellow
    $port = 5501
    $listener = New-Object System.Net.Sockets.TcpListener ([System.Net.IPAddress]::Any, $port)
    $listener.Start()
}

Write-Host "==========================================================" -ForegroundColor Cyan
Write-Host "  DASBOR MOBILE SERVER AKTIF & TERHUBUNG!                 " -ForegroundColor Green
Write-Host "==========================================================" -ForegroundColor Cyan
Write-Host ""
Write-Host "  BUKA LINK INI DI PERANGKAT ANDROID ANDA:" -ForegroundColor Yellow
Write-Host "  >> http://${localIp}:${port}" -ForegroundColor White
Write-Host ""
Write-Host "  ATAU BUKA DI LAPTOP INI:" -ForegroundColor Yellow
Write-Host "  >> http://localhost:${port}" -ForegroundColor White
Write-Host ""
Write-Host "  PETUNJUK DI CHROME HP:" -ForegroundColor Cyan
Write-Host "  1. Pastikan mengetik 'http://' secara lengkap di awal URL." -ForegroundColor Gray
Write-Host "  2. Buka menu titik tiga (titik 3 di kanan atas Chrome)." -ForegroundColor Gray
Write-Host "  3. Pilih 'Tambahkan ke Layar Utama' / 'Install Aplikasi'." -ForegroundColor Gray
Write-Host ""
Write-Host "  Tekan Ctrl + C di jendela ini untuk menghentikan server." -ForegroundColor Red
Write-Host "==========================================================" -ForegroundColor Cyan

$mimeTypes = @{
    ".html" = "text/html; charset=utf-8"
    ".htm"  = "text/html; charset=utf-8"
    ".js"   = "application/javascript; charset=utf-8"
    ".json" = "application/manifest+json; charset=utf-8"
    ".png"  = "image/png"
    ".jpg"  = "image/jpeg"
    ".svg"  = "image/svg+xml"
    ".css"  = "text/css; charset=utf-8"
}

while ($true) {
    try {
        $client = $listener.AcceptTcpClient()
        $stream = $client.GetStream()
        $reader = New-Object System.IO.StreamReader($stream)
        $requestLine = $reader.ReadLine()

        if ([string]::IsNullOrWhiteSpace($requestLine)) {
            $client.Close()
            continue
        }

        # Parsing request: GET /path HTTP/1.1
        $tokens = $requestLine.Split(' ')
        $rawPath = if ($tokens.Length -ge 2) { $tokens[1] } else { "/" }
        $cleanPath = $rawPath.Split('?')[0].TrimStart('/')

        if ([string]::IsNullOrWhiteSpace($cleanPath)) { $cleanPath = "index.html" }

        $filePath = Join-Path $folder $cleanPath

        if (Test-Path $filePath -PathType Leaf) {
            $ext = [System.IO.Path]::GetExtension($filePath).ToLower()
            $mime = if ($mimeTypes.ContainsKey($ext)) { $mimeTypes[$ext] } else { "application/octet-stream" }
            $contentBytes = [System.IO.File]::ReadAllBytes($filePath)

            $header = "HTTP/1.1 200 OK`r`n" +
                      "Content-Type: $mime`r`n" +
                      "Content-Length: $($contentBytes.Length)`r`n" +
                      "Access-Control-Allow-Origin: *`r`n" +
                      "Connection: close`r`n`r`n"

            $headerBytes = [System.Text.Encoding]::ASCII.GetBytes($header)
            $stream.Write($headerBytes, 0, $headerBytes.Length)
            $stream.Write($contentBytes, 0, $contentBytes.Length)
        } else {
            $notFound = "HTTP/1.1 404 Not Found`r`nContent-Length: 9`r`nConnection: close`r`n`r`nNot Found"
            $errBytes = [System.Text.Encoding]::ASCII.GetBytes($notFound)
            $stream.Write($errBytes, 0, $errBytes.Length)
        }

        $stream.Flush()
        $client.Close()
    } catch {
        # Loop continues
    }
}
