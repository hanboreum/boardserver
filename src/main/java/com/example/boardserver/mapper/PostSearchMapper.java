package com.example.boardserver.mapper;

import com.example.boardserver.dto.PostDTO;
import com.example.boardserver.dto.request.PostSearchRequest;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostSearchMapper {

    public List<PostDTO> selectPosts (PostSearchRequest request);

    public List<PostDTO> getPostsByTag(String tagName);
}
