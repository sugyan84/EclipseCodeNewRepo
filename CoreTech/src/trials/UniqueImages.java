package trials;

import java.util.*;

class UniqueImages
{
	public static class Image
	{
		private String	filename;
		private int		width;
		private int		height;

		public Image(String filename, int width, int height)
		{
			this.filename = filename;
			this.width = width;
			this.height = height;
		}

		/**
		 * Two Images are considered equal if they have the same filename
		 * (without the extension), and the same number of pixels. Thus,
		 * flag.jpg with width=60 height=40 is equal to flag.gif with width=40
		 * and height=60
		 */
		public boolean equals(Object other)
		{
			Image o = (Image) other;
			if(filename == null || o.filename == null) return false;
			
			String[] components = this.filename.split("\\.");
			String[] ocomponents = o.filename.split("\\.");
					
			//Supported below line with braces for extreme clarity and Strings compared Case-Insensitive
			return (components[0].trim().equalsIgnoreCase(ocomponents[0])) && ((width * height) == (o.width * o.height));
		}
		
		//Added below hashCode() method
		public int hashCode()
		{
			int hashCodeClculated=0;
			
			hashCodeClculated= (this.width*this.height+(this.filename.length()));
			
			return hashCodeClculated;
		}

		public String toString()
		{
			return "Image: filename=" + filename + " Size=" + (width * height);
		}
	}

	public static void printImages(Set<Image> images)
	{
		for(Image image : images)
		{
			System.out.println(image);
		}
	}

	public static void main(String[] args)
	{
		Image[] images =
		{ 	new Image("flag.jpg", 40, 60),
            new Image("flag.gif", 40, 60),
            new Image("smile.gif", 100, 200),
            new Image("smile.gif", 50, 400),
            new Image("other.jpg", 40, 60),
            new Image("lenna.jpg", 512, 512),
            new Image("Lenna.jpg", 512, 512)				
		};
		
		Set<Image> set = new HashSet<Image>(Arrays.asList(images));
		
		UniqueImages.printImages(set);
		
	}
}
