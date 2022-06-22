package leet.greedy;

import leet.Interfaces.IRemoveKDigits402;

public class RemoveKDigits implements IRemoveKDigits402
{

	@Override
	public String removeKDigits(String num, int k) {
		int len = num.length();
		if (k == len) return "0";

		int remainingK = k;
		char[] charArr = num.toCharArray();
		int index = -1;
		for (int i = 0; i < len; i++) {
			char cur = charArr[i];
			while (index >= 0 && remainingK > 0 && charArr[index] > cur) {
				index--;
				remainingK--;
			}
			index++;
			charArr[index] = cur;
		}

		int offset = 0;
		int length = Math.min(len - k, index + 1);
		for (; offset < length; offset++) {
			if (charArr[offset] != '0') break;
		}

		return offset == length ? "0" : new String(charArr, offset, length - offset);
	}
}
