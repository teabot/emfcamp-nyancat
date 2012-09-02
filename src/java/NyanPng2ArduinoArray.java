import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import javax.imageio.ImageIO;

/**
 * Creates and indexed image array from a PNG. Only useful for images with a
 * palette of < 256 colours.
 */
public class NyanPng2ArduinoArray {

	public static void main(String[] args) {
		int colourIndex = 0;
		Map<Integer, Integer> rgbToIndex = new TreeMap<Integer, Integer>();
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("nyan_pixel.png"));
			int height = img.getHeight();
			int width = img.getWidth();
			int[][] indexed = new int[width][height];
			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {
					int rgb = img.getRGB(x, y) & 0x00ffffff;
					Integer index = rgbToIndex.get(rgb);
					if (index == null) {
						index = colourIndex++;
						rgbToIndex.put(rgb, index);
					}
					indexed[x][y] = index;
				}
			}

			System.out.printf("const int NYAN_WIDTH = %d;\n", width);
			System.out.printf("const int NYAN_HEIGHT = %d;\n", height);
			System.out.printf("const byte NYAN_COLOURS[%d] = {\n",
					rgbToIndex.size());
			int counter = 1;
			Map<Integer, Integer> indexToRgb = new TreeMap<Integer, Integer>();
			for (Map.Entry<Integer, Integer> entry : rgbToIndex.entrySet()) {
				indexToRgb.put(entry.getValue(), entry.getKey());
			}
			for (Map.Entry<Integer, Integer> entry : indexToRgb.entrySet()) {
				System.out.printf("  0x%s",
						Integer.toHexString(entry.getValue() & 0xffffff)
								.toUpperCase());
				if (counter++ == indexToRgb.size()) {
					System.out.printf("\n");
				} else {
					System.out.printf(",\n");
				}
			}
			System.out.printf("};\n");
			System.out.printf("FLASH_ARRAY(int, NYAN_DATA,\n", width * height);
			counter = 1;
			for (int x = 0; x < width; x++) {
				for (int y = 0; y < height; y++) {
					if (y == 0) {
						System.out.printf("  ");
					}
					System.out.printf("%d", indexed[x][y]);
					if (y == (height - 1)) {
						if (x == (width - 1)) {
							System.out.printf("\n");
						} else {
							System.out.printf(",\n");
						}
					} else {
						System.out.printf(", ");
					}
				}
			}
			System.out.printf(");\n");
		} catch (IOException e) {
		}
	}

}
