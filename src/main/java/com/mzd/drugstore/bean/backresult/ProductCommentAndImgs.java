package com.mzd.drugstore.bean.backresult;

import com.mzd.drugstore.bean.generator.Comment;
import com.mzd.drugstore.bean.generator.Commentimgs;
import com.mzd.drugstore.bean.generator.Productimgs;
import lombok.Data;

import java.util.List;

@Data
public class ProductCommentAndImgs extends Comment {
    List<Commentimgs> commentimgs;
}
