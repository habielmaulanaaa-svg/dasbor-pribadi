Add-Type -AssemblyName System.Drawing

function Generate-AppIcon([int]$size, [string]$outPath) {
    $bmp = New-Object System.Drawing.Bitmap($size, $size)
    $g = [System.Drawing.Graphics]::FromImage($bmp)
    $g.SmoothingMode = [System.Drawing.Drawing2D.SmoothingMode]::AntiAlias
    $g.TextRenderingHint = [System.Drawing.Text.TextRenderingHint]::AntiAlias

    # Background gradient (#2563eb to #0e1621)
    $rect = New-Object System.Drawing.Rectangle(0, 0, $size, $size)
    $c1 = [System.Drawing.Color]::FromArgb(255, 37, 99, 235)
    $c2 = [System.Drawing.Color]::FromArgb(255, 14, 22, 33)
    $brush = New-Object System.Drawing.Drawing2D.LinearGradientBrush($rect, $c1, $c2, 45.0)
    $g.FillRectangle($brush, $rect)

    # Rounded inner badge
    $pad = [int]($size * 0.12)
    $innerRect = New-Object System.Drawing.Rectangle($pad, $pad, ($size - 2 * $pad), ($size - 2 * $pad))
    $innerBrush = New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(45, 255, 255, 255))
    $g.FillEllipse($innerBrush, $innerRect)

    # Draw 'D' Letter
    $font = New-Object System.Drawing.Font("Arial", [float]($size * 0.42), [System.Drawing.FontStyle]::Bold, [System.Drawing.GraphicsUnit]::Pixel)
    $strFormat = New-Object System.Drawing.StringFormat
    $strFormat.Alignment = [System.Drawing.StringAlignment]::Center
    $strFormat.LineAlignment = [System.Drawing.StringAlignment]::Center

    $textBrush = New-Object System.Drawing.SolidBrush([System.Drawing.Color]::White)
    $g.DrawString("D", $font, $textBrush, [float]($size / 2.0), [float]($size / 2.0), $strFormat)

    # Accent dot (#f59e0b)
    $dotSize = [int]($size * 0.12)
    $dotBrush = New-Object System.Drawing.SolidBrush([System.Drawing.Color]::FromArgb(255, 245, 158, 11))
    $g.FillEllipse($dotBrush, [int]($size * 0.65), [int]($size * 0.22), $dotSize, $dotSize)

    $bmp.Save($outPath, [System.Drawing.Imaging.ImageFormat]::Png)
    $g.Dispose()
    $bmp.Dispose()
    Write-Host "Success generating $outPath ($size x $size)"
}

Generate-AppIcon 192 'C:\Users\abilm\.gemini\antigravity\scratch\dasbor-mobile\icon-192.png'
Generate-AppIcon 512 'C:\Users\abilm\.gemini\antigravity\scratch\dasbor-mobile\icon-512.png'
