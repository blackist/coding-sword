package java7.concurrent.controlexecute;

import java.util.concurrent.RecursiveAction;

/**
 * TODO 分支合并框架 ForkJoinPool ForkJoinTask
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2019/6/22
 */
public class BranchMerge {






	private static class UpdateSortor extends RecursiveAction {

		@Override
		protected void compute() {

			UpdateSortor merge1 = new UpdateSortor();
			UpdateSortor merge2 = new UpdateSortor();

			invokeAll(merge1, merge2);

		}
	}
}
