class Calculator {
	int add(int val1, int val2) {
		if (val1 > 0) {
			// val1が正数の場合
			if (Integer.MAX_VALUE - val1 < val2) {
				// 整数最大値からval1を引いた値よりval2が大きいと桁あふれする
			    throw new ArithmeticException("overflow");
			}
		} else {
			// val1が負数の場合
			if (Integer.MIN_VALUE - val1 > val2) {
				// 整数最小値からval1を引いた値よりval2が小さいと桁あふれする
			    throw new ArithmeticException("overflow");
			}
		}

		return val1 + val2;
	}
}
