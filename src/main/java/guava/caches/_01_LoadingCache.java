package guava.caches;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.TimeUnit;

/**
 * TODO Loading Cache
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2020/2/1
 */
public class _01_LoadingCache {


	public static void main(String[] args) {

		LoadingCache<String, String> caches = CacheBuilder.newBuilder()
				.maximumSize(1000)
				.expireAfterWrite(10, TimeUnit.MINUTES)
				.removalListener()
	}
}
