class Calculator {
	int add(int val1, int val2) {
		if (val1 > 0) {
			// val1�������̏ꍇ
			if (Integer.MAX_VALUE - val1 < val2) {
				// �����ő�l����val1���������l���val2���傫���ƌ����ӂꂷ��
			    throw new ArithmeticException("overflow");
			}
		} else {
			// val1�������̏ꍇ
			if (Integer.MIN_VALUE - val1 > val2) {
				// �����ŏ��l����val1���������l���val2���������ƌ����ӂꂷ��
			    throw new ArithmeticException("overflow");
			}
		}

		return val1 + val2;
	}
}
