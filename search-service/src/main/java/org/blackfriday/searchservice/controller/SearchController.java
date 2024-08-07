package org.blackfriday.searchservice.controller;

import lombok.RequiredArgsConstructor;
import org.blackfriday.searchservice.dto.ProductTagsDto;
import org.blackfriday.searchservice.service.SearchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    @PostMapping("/search/addTagCache")
    public void addTagCache(@RequestBody final ProductTagsDto dto) {
        searchService.addTagCache(dto.getProductId(), dto.getTags());
    }

    @PostMapping("/search/removeTagCache")
    public void removeTagCache(@RequestBody final ProductTagsDto dto) {
        searchService.removeTagCache(dto.getProductId(), dto.getTags());
    }

    @GetMapping("/search/tags/{tag}/productsIds")
    public List<Long> getTagProductIds(@PathVariable final String tag) {
        return searchService.getProductsIdsByTag(tag);
    }
}
