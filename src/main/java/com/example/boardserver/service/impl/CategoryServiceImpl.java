package com.example.boardserver.service.impl;

import com.example.boardserver.dto.CategoryDTO;
import com.example.boardserver.mapper.CategoryMapper;
import com.example.boardserver.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;

    @Override
    public void register(String accountId, CategoryDTO categoryDTO) {
        if (accountId != null) {
            try {
                categoryMapper.register(categoryDTO);
            } catch (RuntimeException e) {
                log.error("register ERROR {}", categoryDTO);
                throw new RuntimeException("register ERROR! 상품등록 메서드를 확인하세요");
            }
        } else {
            log.error("register ERROR {}", categoryDTO);
            throw new RuntimeException("else - register ERROR! 상품등록 메서드를 확인하세요");
        }
    }

    @Override
    public void update(CategoryDTO categoryDTO) {
        if (categoryDTO != null && categoryDTO.getName() != null) {
            try {
                categoryMapper.updateCategory(categoryDTO);
            } catch (RuntimeException e) {
                log.error("update ERROR {}", categoryDTO);
                throw new RuntimeException("update ERROR !!! 카테고리 변경 메서드를 확인하세요");
            }

        } else {
            log.error("update ERROR {}", categoryDTO);
            throw new RuntimeException("else - update ERROR !!! 카테고리 변경 메서드를 확인하세요");
        }
    }

    @Override
    public void delete(int categoryId) {
        if (categoryId != 0) {
            try {
                categoryMapper.deleteCategory(categoryId);
            } catch (RuntimeException e) {
                log.error("delete ERROR {}", categoryId);
                throw new RuntimeException("Delete ERROR!! 카테고리 삭제 메소드를 확안해주세요");
            }

        } else {
            log.error("delete ERROR {}", categoryId);
            throw new RuntimeException("else - Delete ERROR!! 카테고리 삭제 메소드를 확안해주세요");
        }
    }
}
