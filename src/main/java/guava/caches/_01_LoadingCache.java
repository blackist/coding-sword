package guava.caches;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import org.jboss.netty.util.internal.ConcurrentHashMap;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * TODO Loading Cache
 *
 * @author L.L Dong<liangl.dong@qq.com>
 * @since 2020/2/1
 */
public class _01_LoadingCache {


	public static void main(String[] args) throws ExecutionException {

		LoadingCache<String, Long> longCahce = CacheBuilder.newBuilder()
				.maximumSize(1000)
				.expireAfterWrite(10, TimeUnit.MINUTES)
				.build(new CacheLoader<String, Long>() {
					@Override
					public Long load(String key) throws Exception {
						return computeLong();
					}
				});
		long start = System.currentTimeMillis();
		System.out.println(longCahce.get("longK1"));
		long period = System.currentTimeMillis() - start;
		System.out.println("Running: " + period);

		start = System.currentTimeMillis();
		System.out.println(longCahce.get("longK1"));
		period = System.currentTimeMillis() - start;
		System.out.println("Running: " + period);

		start = System.currentTimeMillis();
		ConcurrentMap<String, Long> cm = longCahce.asMap();
		System.out.println(cm.get("longK2"));
		System.out.println(longCahce.get("longK2"));
		period = System.currentTimeMillis() - start;
		// 153ms
		System.out.println("Running: " + period);

		start = System.currentTimeMillis();
		System.out.println(longCahce.get("longK2"));
		period = System.currentTimeMillis() - start;
		// 0ms
		System.out.println("Running: " + period);

		Cache<String, Long> cache = CacheBuilder.newBuilder()
				.maximumSize(1000)
				.build();

		// callabele
		start = System.currentTimeMillis();
		System.out.println(cache.get("ck", _01_LoadingCache::computeLong));
		period = System.currentTimeMillis() - start;
		// 0ms
		System.out.println("Running: " + period);

		start = System.currentTimeMillis();
		System.out.println(cache.get("ck", _01_LoadingCache::computeLong));
		period = System.currentTimeMillis() - start;
		// 0ms
		System.out.println("Running: " + period);

		cache.put("ck1", 99L);
		ConcurrentMap<String, Long> cacheMap= cache.asMap();
		System.out.println(cacheMap.get("ck"));
		cache.put("ck2", 100L);
		System.out.println(cacheMap.get("ck2"));
		// 显式插入1
		cacheMap.putIfAbsent("ck3", 101L);
		// 显示插入2  get(key,  callable) 会创建缓存
		System.out.println(cache.get("ck3", _01_LoadingCache::computeLong));
	}

	private static Long computeLong() {
		Random r = new Random();
		long t = 0L;
		for (int i = 10000000; i > 0; --i) {
			t += r.nextInt(100);
		}
		return t;
	}
}
