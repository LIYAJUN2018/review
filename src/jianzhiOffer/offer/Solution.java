package jianzhiOffer.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

import jianzhiOffer.offer.datastructure.ListNode;
import jianzhiOffer.offer.datastructure.TreeNode;

public class Solution {

	/**
	 * 
	 * 二维数组中的查找 题目描述：在一个二维数组中（每个一维数组的长度相同）， 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
	 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
	 *
	 * 解题思路：由于每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序
	 * 从左下方m开始查找，左下方的数字一定是本列最大，本行最小，如果target>m，向右查找 如果target<m，向上查找 本方法由 LYJ
	 * 创建于2019年8月24日 下午5:28:14
	 * 
	 * @param target
	 * @param array
	 * @return boolean
	 */
	public boolean Find(int target, int[][] array) {

		if (array.length == 0)
			return false;

		int row = array.length - 1;
		for (int column = 0; row >= 0 && column < array[row].length; column++) {
			if (array[row].length == 0)
				return false;
			if (target > array[row][column]) {
				continue;
			} else if (target < array[row][column]) {
				row--;
				column--;
			} else {
				return true;
			}
		}

		return false;

	}

	/**
	 * 
	 * 题目描述：请实现一个函数，将一个字符串中的每个空格替换成“%20”。 例如，当字符串为We Are
	 * Happy.则经过替换之后的字符串为We%20Are%20Happy。
	 * 
	 * 解题思路：利用String的replace()方法 本方法由 LYJ 创建于2019年8月24日 下午5:31:21
	 * 
	 * @param str
	 * @return String
	 */
	public String replaceSpace(StringBuffer str) {

		String string = str.toString();
		return string.replace(" ", "%20");
	}

	/**
	 * 题目描述：输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
	 * 
	 * 解题思路：先存将链表里的数据存放到一个中间ArrayList中，再从后往前存放到最终List中 本方法由 LYJ 创建于2019年8月24日
	 * 下午5:43:21
	 * 
	 * @param listNode
	 * @return ArrayList<Integer>
	 */
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

		ArrayList<Integer> temp = new ArrayList<Integer>();
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		ListNode p = listNode;
		while (null != p) {
			temp.add(p.val);
			p = p.next;
		}
		for (int i = temp.size() - 1; i >= 0; i--) {
			arrayList.add(temp.get(i));
		}
		return arrayList;
	}

	/**
	 * 题目描述：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
	 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
	 * 
	 * 解题思路： 根据中序遍历和前序遍历可以确定二叉树，具体过程为： 1、根据前序序列第一个结点确定根结点 2、根据根结点在中序序列中的位置分割出左右两个子序列
	 * 3、对左子树和右子树分别递归使用同样的方法继续分解 例如： 前序序列{1,2,4,7,3,5,6,8} = pre
	 * 中序序列{4,7,2,1,5,3,8,6} = in 1、根据当前前序序列的第一个结点确定根结点，为 1 2、找到 1 在中序遍历序列中的位置，为
	 * in[3] 3、切割左右子树，则 in[3] 前面的为左子树， in[3] 后面的为右子树
	 * 4、则切割后的左子树前序序列为：{2,4,7}，切割后的左子树中序序列为：{4,7,2}；
	 * 切割后的右子树前序序列为：{3,5,6,8}，切割后的右子树中序序列为：{5,3,8,6} 5、对子树分别使用同样的方法分解
	 * 
	 * 本方法由 LYJ 创建于2019年8月24日 下午6:08:56
	 * 
	 * @param pre
	 * @param in
	 * @return TreeNode
	 */
	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		if (pre.length == 0 || in.length == 0) {
			return null;
		}

		TreeNode treeNode = new TreeNode(pre[0]);

		int root = pre[0];
		for (int i = 0; i < in.length; i++) {
			if (in[i] == root) {
				// 左子树，pre从根节点后一个到i，in从0到i-1
				treeNode.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));

				// 右子树，pre、in都从i+1到最后
				treeNode.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length),
						Arrays.copyOfRange(in, i + 1, in.length));
			}
		}
		return treeNode;
	}

	/**
	 * 题目描述： 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
	 * 
	 * 解题思路： 利用中间栈，先将stack1的数据push到中间栈中，得到最先入队的数据，pop。 再将中间栈的数据push回stack1中
	 */

	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public void push(int node) {
		stack1.push(node);
	}

	public int pop() {
		while (!stack1.empty()) {
			Integer pop = stack1.pop();
			stack2.push(pop);
		}
		Integer pop2 = stack2.pop();
		while (!stack2.empty()) {
			Integer pop = stack2.pop();
			stack1.push(pop);
		}
		return pop2;
	}

	/**
	 * 
	 * 题目描述： 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
	 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
	 *
	 * 解题思路 前后两个比较，如果遇到后一个大于前面的就到了旋转点，返回即可 本方法由 LYJ 创建于2019年8月24日 下午6:43:46
	 * 
	 * @param array
	 * @return int
	 */
	public int minNumberInRotateArray(int[] array) {

		if (array.length == 0) {
			return 0;
		}
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i + 1]) {
				return array[i + 1];
			}
		}
		return array[0];
	}

	/**
	 * 题目描述：大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）
	 * 
	 * 解题思路： 斐波那契数列的标准公式为：F(1)=1，F(2)=1, F(n)=F(n-1)+F(n-2)（n>=3，n∈N*） 本方法由 LYJ
	 * 创建于2019年8月27日 下午4:35:54
	 * 
	 * @param n
	 * @return int
	 */
	public int Fibonacci(int n) {

		if (n <= 1) {
			return n;
		}
		return Fibonacci(n - 2) + Fibonacci(n - 1);
	}

	/**
	 * 题目描述： 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
	 *
	 * 解题思路： 这题本质就是斐波那契数列，跳n级台阶相当于n-1和n-2级台阶的和， 原因：n级台阶就相当于n-1级再跳一次一阶的和n-2级再跳一次2阶的
	 * 本方法由 LYJ 创建于2019年8月27日 下午4:40:41
	 * 
	 * @param target
	 * @return int
	 */
	public int JumpFloor(int target) {

		if (target <= 2) {
			return target;
		}
		return JumpFloor(target - 2) + JumpFloor(target - 1);
	}

	/**
	 * 题目描述： 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
	 * 
	 * 解题思路： 易知 f(n)=f(n-1)+f(n-2)+……f(1)；f(n-1)=f(n-2)+……f(1)；两式相减得f(n)=2f(n-1)
	 * 本方法由 LYJ 创建于2019年8月27日 下午5:07:03
	 * 
	 * @param target
	 * @return int
	 */
	public int JumpFloorII(int target) {
		if (target <= 1) {
			return target;
		}

		int sum = 1;
		for (int i = 2; i <= target; i++) {
			sum = 2 * sum;
		}
		return sum;

	}

	/**
	 * 
	 * 为了得到一个数的"相反数",我们将这个数的数字顺序颠倒,然后再加上原先的数得到"相反数"。
	 * 例如,为了得到1325的"相反数",首先我们将该数的数字顺序颠倒,我们得到5231,之后再加上原先的数,我们得到5231+1325=6556.
	 * 如果颠倒之后的数字有前缀零,前缀零将会被忽略。例如n = 100, 颠倒之后是1. 本方法由 LYJ 创建于2019年8月27日 下午9:00:58
	 * void
	 */
	public void opposite() {
		Scanner sc = new Scanner(System.in);
		int nextInt = sc.nextInt();
		int n = nextInt;
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		while (n > 0) {
			arrayList.add(n % 10);
			n = n / 10;
		}

		int sum = 0;
		for (int i = 0; i < arrayList.size(); i++) {
			sum += arrayList.get(i) * Math.pow(10, arrayList.size() - 1 - i);
		}
		sum += nextInt;
		System.out.println(sum);

	}

	/**
	 * 题目描述： 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
	 * 
	 * 解题思路： 被覆盖的目标矩形的形状： 2*n 每次新增加的一列，（1）如果竖着放对应的情况与 target为 n-1 时相同；
	 * （2如果横着放，对应的情况与 target 为 n-2 时相同。 本方法由 LYJ 创建于2019年8月29日 下午4:01:51
	 * 
	 * @param target
	 * @return int
	 */
	public int RectCover(int target) {

		if (target <= 2) {
			return target;
		}
		return RectCover(target - 2) + RectCover(target - 1);
	}

	/**
	 * 题目描述： 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示
	 * 
	 * 解题思路： 每次判断最低位是不是为一，然后无符号右移一位 java中负数都是用补码表示的，所以只要统计1的位数即可。
	 * 
	 * 本方法由 LYJ 创建于2019年8月29日 下午4:15:43
	 * 
	 * @param n
	 * @return int
	 */
	public static int NumberOf1(int n) {

		int r = 0;
		int count = 0;
		while (n != 0) {
			count += n & 1;
			n = n >>> 1;
		}
		return count;
	}

	/**
	 * 题目描述：
	 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。保证base和exponent不同时为0
	 * 
	 * 解题思路： 1.全面考察指数的正负、底数是否为零等情况。 2.写出指数的二进制表达，例如13表达为二进制1101。 3.举例:10^1101 =
	 * 10^0001*10^0100*10^1000。 4.通过&1和>>1来逐位读取1101，为1时将该位代表的乘数累乘到最终结果。 本方法由 LYJ
	 * 创建于2019年8月29日 下午4:39:52
	 * 
	 * @param base
	 * @param exponent
	 * @return double
	 */
	public double Power(double base, int n) {
		double res = 1, curr = base;
		int exponent;
		if (n > 0) {
			exponent = n;
		} else if (n < 0) {
			if (base == 0)
				throw new RuntimeException("分母不能为0");
			exponent = -n;
		} else {// n==0
			return 1;// 0的0次方
		}
		while (exponent != 0) {
			if ((exponent & 1) == 1)
				res *= curr;
			curr *= curr;// 翻倍
			exponent >>= 1;// 右移一位
		}
		return n >= 0 ? res : (1 / res);
	}

	/**
	 * 
	  * 题目描述：
	  * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
	  * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
	  * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
	  * 解题思路：
	  * 用两个list分别存储奇数和偶数，然后再放回数组中
	  * 本方法由 LYJ 创建于2019年9月1日 下午7:45:59
	 * @param array void
	 */
	public static void reOrderArray(int[] array) {

		ArrayList<Integer> ji = new ArrayList<Integer>();
		ArrayList<Integer> ou = new ArrayList<Integer>();
		
		for (Integer integer : array) {
			if(integer % 2 == 0) {
				ou.add(integer);
			}else {
				ji.add(integer);
			}
		}
		int i;
		for(i = 0; i < ji.size(); i ++) {
			array[i] = ji.get(i);
		}
		for(int j = 0; j < ou.size(); j++) {
			array[i] = ou.get(j);
			i++;
		}
		
	}
	
	/**
	 * 
	  * 题目描述：
	  * 输入一个链表，输出该链表中倒数第k个结点
	  * 解题思路：
	  * 通过两个指针p1,p2，p1先走到k-1，然后两个指针同时走剩下的n-k+1
	  * 本方法由 LYJ 创建于2019年9月1日 下午7:57:15
	 * @param head
	 * @param k
	 * @return ListNode
	 */
	public static ListNode FindKthToTail(ListNode head,int k) {
		
		if(null == head || k < 1) {
			return null;
		}
		ListNode p1 = head;
		ListNode p2 = head;
		
		for(int i = 0; (i < k - 1) && (p1 != null); i ++) {
			p1 = p1.next;
		}
		if(p1 == null) {
			return null;
		}
		while(p1.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}

		return p2;
    }
	/**
	 * 题目描述：
	  * 输入一个链表，反转链表后，输出新链表的表头。
	  * 本方法由 LYJ 创建于2019年9月1日 下午8:20:10
	 * @param head
	 * @return ListNode
	 */
	public static ListNode ReverseList(ListNode head) {
		if(null == head) {
			return null;
		}
		
		ListNode pre = null;
		ListNode curr = null;
		while(null != head.next) {
			curr = head.next;
			head.next = pre;
			pre = head;
			head = curr;
		}
		head.next = pre;
		
		return head;
    }
	
	/**
	 * 
	  * 题目描述：
	  * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
	  * 本方法由 LYJ 创建于2019年9月1日 下午8:32:05
	 * @param list1
	 * @param list2
	 * @return ListNode
	 */
	 public ListNode Merge(ListNode list1,ListNode list2) {
		 
		 if(null == list1) {
			 return list2;
		 }
		 if(null == list2) {
			 return list1;
		 }
		 
		 ListNode head = new ListNode(0);
		 ListNode p = head;
		 while((null != list1) && (null != list2)) {
			 ListNode listNode;
			 if(list1.val <= list2.val) {
				 listNode = new ListNode(list1.val);
				 list1 = list1.next;
			 } else {
				 listNode = new ListNode(list2.val);
				 list2 = list2.next;
			 }
			 p.next = listNode;
			 p = p.next;
		 }
		 if(null == list1) {
			 ListNode listNode;
			 while(null != list2) {
				 listNode = new ListNode(list2.val);
				 p.next = listNode;
				 p = p.next;
				 list2 = list2.next;
			 }
		 }
		 if(null == list2) {
			 ListNode listNode;
			 while(null != list1) {
				 listNode = new ListNode(list1.val);
				 p.next = listNode;
				 p = p.next;
				 list1 = list1.next;
			 }
		 }
		 
		 return head.next;
	        
	    }

	public static void main(String[] args) {
		//int[] array = {1,2,3,4,5,6,7};
		ListNode listNode = new ListNode(1);
		ListNode listNode1 = new ListNode(2);
		ListNode listNode2 = new ListNode(3);
		ListNode listNode3 = new ListNode(4);
		ListNode listNode4 = new ListNode(5);
		listNode.next = listNode1;
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		listNode3.next = listNode4;
		listNode4.next = null;
		
		ReverseList(listNode);
	}

}
