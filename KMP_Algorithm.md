<!-- https://ghh3809.github.io/2018/08/05/kmp/ -->
<!-- https://blog.csdn.net/v_july_v/article/details/7041827 -->

```java
public int KMP(String P, String T) {
	int n = T.length(), i = 0; // 文本串指针
	int m = P.length(), j = 0; // 模式串指针
	int[] next = buildNext(P); // 构建模式串P的next表
	while ((j < m) && (i < n)) {
		if ((j < 0) || (P.charAt(j) == T.charAt(i))) { // 匹配时，移动到下一字符
			j ++; i ++;
		} else { // 不匹配时，加速移动模式串
			j = next[j];
		}
	}
    // j == m means there is match
    if(j == m) ? i - j : -1;
}
public int[] buildNext(String P) {
	int m = P.length();
	int[] next = new int[m];
	next[0] = -1; // 初始化next表
	int t = -1, j = 0; // j为“主”串指针，t为移动串指针
	while (j < m - 1) {
		if ((t < 0) || (P.charAt(j) == P.charAt(t))) {
			// 匹配的情况下，若</!-->后一元素不相等时才能移动到t，否则要直接移动到next[t](递归的查，防止移动后再次不匹配)
			j ++; t ++;
			next[j] = (P.charAt(j) != P.charAt(t) ? t : next[t]);
		} else { // 不匹配时，加速移动模式串
			t = next[t];
		}
	}
	return next;
}
```
