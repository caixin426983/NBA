package cx.Tools;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Random;

/**
 * Created by Administrator on 2017-8-16.
 */
public class SecurityImage {

    public SecurityImage()
    {
    }

    public static BufferedImage createImage(String securityCode)
    {
        int codeLength = securityCode.length();
        int fontSize = 15;
        int fontWidth = fontSize + 1;
        int width = codeLength * fontWidth + 6;
        int height = fontSize * 2 + 1;
        BufferedImage image = new BufferedImage(width, height, 1);
        Graphics g = image.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.LIGHT_GRAY);
        g.setFont(new Font("Arial", 1, height - 2));
        g.drawRect(0, 0, width - 1, height - 1);
        Random rand = new Random();
        g.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i < codeLength * 6; i++)
        {
            int x = rand.nextInt(width);
            int y = rand.nextInt(height);
            g.drawRect(x, y, 1, 1);
        }

        int codeY = height - 10;
        g.setColor(new Color(19, 148, 246));
        g.setFont(new Font("Georgia", 1, fontSize));
        for (int i = 0; i < codeLength; i++)
            g.drawString(String.valueOf(securityCode.charAt(i)), i * 16 + 5, codeY);

        g.dispose();
        return image;
    }

    public static ByteArrayInputStream getImageAsInputStream(String securityCode)
    {
        BufferedImage image = createImage(securityCode);
        return convertImageToStream(image);
    }

    public static ByteArrayInputStream convertImageToStream(BufferedImage image)
    {
        ByteArrayInputStream inputStream = null;
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(outStream);
        try
        {
            encoder.encode(image);
            byte b[] = outStream.toByteArray();
            inputStream = new ByteArrayInputStream(b);
        }
        catch (Exception exception) { }
        return inputStream;
    }


}
