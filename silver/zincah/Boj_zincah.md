Sliver 백준 문제 풀이
=====

> solved.ac sliver 단계 문제를 단계별로 풀고 각 문제에서 기억해야 할 부분에 대해서 정리한다. 


<details>
<summary>백준 1259 : 팰린드롬수</summary>
<div markdown="1">

* 입력받은 문자열을 거꾸로 뒤집어서 문제를 해결할 수 있음
* 해결방법 
  * for 문 사용
  * StringBuffer.reverse() method 사용

<pre>
<code>
    StringBuffer sb = new StringBuffer(str);
    String reverseStr = sb.reverse().toString();
</code>
</pre>

</div>
</details>


<details>
<summary>백준 2609 : 최대공약수와 최소공배수</summary>
<div markdown="1">

* 최대공약수 : 두 수가 나누어 떨어지는 수 중에서 가장 큰 수
* 최소공배수 : 두 수의 곱에서 최대 공약수로 나누면 나오는 값

<pre>
<code>
  // 최소공배수
  최소공배수 = first*second/최대공약수
</code>
</pre>

</div>
</details>


<details>
<summary>백준 2775 : 부녀회장이 될테야</summary>
<div markdown="1">

* 2차원 배열 사용

</div>
</details>