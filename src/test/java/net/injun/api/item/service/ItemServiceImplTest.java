package net.injun.api.item.service;

import net.injun.api.item.domain.Item;
import net.injun.api.item.repository.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
class ItemServiceImplTest {
    private ItemServiceImpl itemService;
    // jpa 는 new 를 만들수 없어 mock 객체를 만든다.
    @Mock
    ItemRepository itemRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        itemService = new ItemServiceImpl(itemRepository);
    }

    @Test
    void findAll() {
        Item item = Item.builder().itemBrand("삼성").itemName("갤럭시").itemColor("흑색").build();
        given(itemService.findAll().size()).willReturn(1);
        assertThat(item.getItemName(),is(equalTo("갤럭시")));
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void existsById() {
    }

    @Test
    void count() {
    }

    @Test
    void deleteAll() {
    }

    @Test
    void deleteById() {
    }
}