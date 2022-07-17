package leet.dynamic;

import leet.Interfaces.INumRectForPoint2250;

import java.util.ArrayList;
import java.util.Arrays;

// todo examine other solutions, mine has too many redundant steps necessitated by Java
public class NumRectForPointOriginal implements INumRectForPoint2250
{
	@Override
	public int[] countRectangles(int[][] rectangles, int[][] points) {
		ArrayList<Integer>[] orderedRects = new ArrayList[101];
		// for (int i=0; i<100;i++) sortedRects [i] =  new ArrayList<>();
		int maxRectY = 0;
		for (int [] rect : rectangles)
		{
			ArrayList<Integer> list = orderedRects[rect[1]];
			if (list == null)
			{
				list = new ArrayList<>();
				orderedRects[rect[1]] = list;
				if (maxRectY < rect[1]) maxRectY = rect[1];
			}
			list.add(rect[0]);
		}
		maxRectY++; // increase by 1 for easier use

		int [][] sortedRects = new int [maxRectY][];
		for (int i=0;i<maxRectY;i++)
		{
			ArrayList<Integer> list = orderedRects[i];
			if (list == null) continue;

			int [] heights = new int[list.size()];
			int j=0;
			for (int h : list)
			{
				heights[j] = h;
				j++;
			}
			sortedRects[i] = heights;
			Arrays.parallelSort(heights);
		}

		int [] count = new int[points.length];
		for (int i=0;i< points.length;i++)
		{
			int [] point = points[i];
			for (int j=point[1]; j<maxRectY;j++ )
			{
				int [] rectHeight = sortedRects[j];
				if (rectHeight == null) continue;
				count[i] += findNumGreaterThanOrEqual(rectHeight, point[0]);
			}
		}

		return count;
	}

	public int findNumGreaterThanOrEqual(int [] heights, int pointX)
	{
		int min = 0;
		int max = heights.length - 1;

		while (min < max)
		{
			int mid = (max + min) / 2;
			if (heights[mid] > pointX)
			{
				max = mid - 1;
			}
			else if (heights[mid] < pointX)
			{
				min = mid + 1;
			}
			else
			{
				return heights.length - mid;
			}
		}
		return heights.length - min - (heights[min] < pointX ? 1 : 0); // min can never exceed max, but max can be below min
	}
}
