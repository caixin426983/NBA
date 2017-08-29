package cx.Tools;

import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Administrator on 2017-8-16.
 */
public class ImageCut {

    public ImageCut()
    {
    }

    public static int[] scaleAndGetSize(String srcImageFile, String result, int scale, boolean flag)
    {
        int _size[] = new int[2];
        try
        {
            BufferedImage src = ImageIO.read(new File(srcImageFile));
            int width = src.getWidth();
            int height = src.getHeight();
            if (flag)
            {
                width *= scale;
                height *= scale;
            } else
            {
                width /= scale;
                height /= scale;
            }
            _size[0] = width;
            _size[1] = height;
            Image image = src.getScaledInstance(width, height, 1);
            BufferedImage tag = new BufferedImage(width, height, 1);
            Graphics g = tag.getGraphics();
            g.drawImage(image, 0, 0, null);
            g.dispose();
            ImageIO.write(tag, "JPEG", new File(result));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return _size;
    }

    public static void scale(String srcImageFile, String result, int scale, boolean flag)
    {
        try
        {
            BufferedImage src = ImageIO.read(new File(srcImageFile));
            int width = src.getWidth();
            int height = src.getHeight();
            if (flag)
            {
                width *= scale;
                height *= scale;
            } else
            {
                width /= scale;
                height /= scale;
            }
            Image image = src.getScaledInstance(width, height, 1);
            BufferedImage tag = new BufferedImage(width, height, 1);
            Graphics g = tag.getGraphics();
            g.drawImage(image, 0, 0, null);
            g.dispose();
            ImageIO.write(tag, "JPEG", new File(result));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void scale(String srcImageFile, String result, int targetWidth, int targetHeight)
    {
        try
        {
            BufferedImage src = ImageIO.read(new File(srcImageFile));
            int width = src.getWidth();
            int height = src.getHeight();
            if (width > targetWidth)
            {
                int scale = width / targetWidth;
                width /= scale;
                height /= scale;
            }
            Image image = src.getScaledInstance(width, height, 1);
            BufferedImage tag = new BufferedImage(width, height, 1);
            Graphics g = tag.getGraphics();
            g.drawImage(image, 0, 0, null);
            g.dispose();
            ImageIO.write(tag, "JPEG", new File(result));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void scale(String srcImageFile, String result, float quality)
    {
        try
        {
            Thumbnails.of(new String[] {
                    srcImageFile
            }).scale(1.0D).outputQuality(quality).outputFormat("jpg").toFile(result);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void scaleFix(String srcImageFile, String result, int width, int height, boolean isEllipse)
    {
        try
        {
            BufferedImage src = ImageIO.read(new File(srcImageFile));
            Image image = src.getScaledInstance(width, height, 1);
            BufferedImage tag = new BufferedImage(width, height, 1);
            if (isEllipse)
            {
                java.awt.geom.Ellipse2D.Double shape = new java.awt.geom.Ellipse2D.Double(0.0D, 0.0D, width, height);
                Graphics2D g2 = tag.createGraphics();
                tag = g2.getDeviceConfiguration().createCompatibleImage(width, height, 3);
                g2.dispose();
                g2 = tag.createGraphics();
                g2.setClip(shape);
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.drawImage(image, 0, 0, null);
                g2.dispose();
            } else
            {
                Graphics g = tag.getGraphics();
                g.drawImage(image, 0, 0, null);
                g.dispose();
            }
            ImageIO.write(tag, "png", new File(result));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void cut(String srcImageFile, String descDir, int destWidth, int destHeight)
    {
        try
        {
            BufferedImage bi = ImageIO.read(new File(srcImageFile));
            int srcWidth = bi.getHeight();
            int srcHeight = bi.getWidth();
            if (srcWidth > destWidth && srcHeight > destHeight)
            {
                Image image = bi.getScaledInstance(srcWidth, srcHeight, 1);
                destWidth = 200;
                destHeight = 150;
                int cols = 0;
                int rows = 0;
                if (srcWidth % destWidth == 0)
                    cols = srcWidth / destWidth;
                else
                    cols = (int)Math.floor(srcWidth / destWidth) + 1;
                if (srcHeight % destHeight == 0)
                    rows = srcHeight / destHeight;
                else
                    rows = (int)Math.floor(srcHeight / destHeight) + 1;
                for (int i = 0; i < rows; i++)
                {
                    for (int j = 0; j < cols; j++)
                    {
                        java.awt.image.ImageFilter cropFilter = new CropImageFilter(j * 200, i * 150, destWidth, destHeight);
                        Image img = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(), cropFilter));
                        BufferedImage tag = new BufferedImage(destWidth, destHeight, 1);
                        Graphics g = tag.getGraphics();
                        g.drawImage(img, 0, 0, null);
                        g.dispose();
                        ImageIO.write(tag, "JPEG", new File((new StringBuilder(String.valueOf(descDir))).append("pre_map_").append(i).append("_").append(j).append(".jpg").toString()));
                    }

                }

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void convert(String source, String result)
    {
        try
        {
            File f = new File(source);
            f.canRead();
            f.canWrite();
            BufferedImage src = ImageIO.read(f);
            ImageIO.write(src, "JPG", new File(result));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void gray(String source, String result)
    {
        try
        {
            BufferedImage src = ImageIO.read(new File(source));
            ColorSpace cs = ColorSpace.getInstance(1003);
            ColorConvertOp op = new ColorConvertOp(cs, null);
            src = op.filter(src, null);
            ImageIO.write(src, "JPEG", new File(result));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String args[])
    {
        System.out.println("开始！");
        long startTime = (new Date()).getTime();
        scale("H:/籣亭照片/b.jpg", "H:/籣亭照片/d.jpg", 0.25F);
        long endTime = (new Date()).getTime();
        System.out.println((new StringBuilder("完成，耗时：")).append(endTime - startTime).toString());
    }

}
