package org.blackfriday.searchservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final StringRedisTemplate stringRedisTemplate;

    /**
     * 검색 서비스의 목적은 캐시로부터 조회하는 것.
     * 캐시가 다 날라가도 검색 성능이 느려질 뿐,
     * 상품 서비스에서 검색하면 되기 때문에 속도가 느려질 뿐 장애에 빠지지는 않는다!!
     */

    // redis: key -> value
    // 검색 서비스: tag(keyword) -> 1, 2, 3, 4, 5, 6 (product id) (Set 자료 구조를 사용)
    public void addTagCache(final Long productId, final List<String> tags) {
        // 특정 프로덕트에 여러 태그를 추가
        final SetOperations<String, String> setOperations = stringRedisTemplate.opsForSet();

        tags.forEach(tag -> {
            setOperations.add(tag, productId.toString()); // tag(keyword) -> 1, 2, 3, 4, 5, 6 (product id): 한 개의 태그에 여러 프로덕트 id.
        });
    }

    public void removeTagCache(final Long productId, List<String> tags) {
        final SetOperations<String, String> setOperations = stringRedisTemplate.opsForSet();

        tags.forEach(tag -> {
            setOperations.remove(tag, productId.toString());
        });
    }

    public List<Long> getProductsIdsByTag(final String tag) {
        final SetOperations<String, String> setOperations = stringRedisTemplate.opsForSet();

        final Set<String> members = setOperations.members(tag);

        if (Objects.isNull(members)) {
            return Collections.emptyList();
        }

        return members.stream().map(Long::parseLong).toList();
    }
}
