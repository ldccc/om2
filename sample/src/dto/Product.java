package dto;

import org.ldccc.om2.dbm.DTM;
import org.ldccc.om2.dto.DTO;

import java.sql.Statement;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Product extends DTO {
    public static final String PRODUCT_BASE = ".products";
    public static final String PRO_NAME = "PRO_NAME";
    public static final String PRO_INFO = "PRO_INFO";
    public static final String SIMPLE_URL = "SIMPLE_URL";
    public static final String COLOR = "COLOR";
    public static final String ORIGIN = "ORIGIN";
    public static final String SUITABLE = "SUITABLE";
    public static final String STYLE = "STYLE";
    public static final String MATERIAL = "MATERIAL";

    public static final List<String> imgList = Arrays.asList("/img/1-1.jpg", "/img/1-2.jpg", "/img/1-3.jpg", "/img/1-4.jpg", "/img/1-5.jpg");

    public Product(Map<String, Object> map) {
        super(map);
    }

    public Product(String proName, String proInfo, String color, String origin, String style, String material) {
        super();
        map.put(PRO_NAME, proName);
        map.put(PRO_INFO, proInfo);
        map.put(SIMPLE_URL, imgList.get((int) (Math.random() * 6)));
        map.put(COLOR, color);
        map.put(ORIGIN, origin);
        map.put(SUITABLE, "飘窗 八角窗 凸窗 落地窗 遮光");
        map.put(STYLE, style);
        map.put(MATERIAL, material);
    }

    private static final DTM<Product> dtm = new DTProduct<>(Product.class, Product.PRODUCT_BASE);

    public static DTM<Product> getDtm() {
        return dtm;
    }

    private static class DTProduct<O extends DTO> extends DTM<O> {
        private DTProduct(Class<O> tClass, String base) {
            super(tClass, base);
        }

        @Override
        protected List<O> getAll(Statement statement) {
            List<O> os= super.getAll(statement);
            Collections.reverse(os);
            return os;
        }
    }
}