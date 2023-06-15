package top.yh.homework.three.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import top.yh.homework.R;

/**
 * @user
 * @date
 */
public class Fruit {
    public int img;
    public String name;

    public Fruit(int img, String name) {
        this.img = img;
        this.name = name;
    }

    private static final Integer[] iconArray = {
            R.drawable.apple, R.drawable.banana, R.drawable.lemon,
            R.drawable.mangosteen, R.drawable.watermelon
    };
    private final static String[] startArray = {
            "苹果", "香蕉", "柠檬",
            "山竹", "西瓜"
    };
    private final static String[] descArray = {
            "苹果（Malus pumila Mill.），蔷薇科苹果属落叶乔木植物，茎干较高，小枝短而粗，呈圆柱形；叶片椭圆形，表面光滑，边缘有锯齿，叶柄粗壮；花朵较小呈伞状，淡粉色，表面有绒毛；果实较大，呈扁球形，果梗短粗；花期5月；果期7~10月。苹果名称最早是见于明代王世懋的《学圃余疏》“北土之苹婆果，即花红一种之变也。",
            "香蕉（Musa nana Lour.），芭蕉科芭蕉属多年生草本植物，植株丛生，有匐匍茎；假茎浓绿有黑色斑点；叶片长圆形，上面为深绿色，无白粉，下面浅绿色；花朵为乳白色或淡紫色；果实呈弯曲的弓状，有棱，果皮为青绿色，成熟后变黄；果肉松软，黄白色，味甜香味浓，无种子",
            "柠檬（Citrus × limon (Linnaeus) Osbeck），芸香科柑橘属木本植物，枝少刺或近于无刺，嫩叶及花芽暗紫红色；叶为卵形或椭圆形；花瓣外面为淡紫红色，内面白色；果实为椭圆形或卵形，果皮厚，柠檬黄色；花期4~5月；果期9~11月。",
            "山竹（拉丁学名：Garcinia mangostana L.）是藤黄科藤黄属植物，原产于马鲁古，亚洲和非洲热带地区广泛栽培，喜欢有机物丰富、pH值在5~6.5的砂壤。",
            "西瓜（Citrullus lanatus (Thunb.) Matsum. & Nakai），是葫芦科西瓜属一年生蔓生藤本植物，形态一般近似于球形或椭圆形，颜色有深绿、浅绿或带有黑绿条带或斑纹；瓜籽多为黑色，呈椭圆形，头尖；茎枝粗壮，有淡黄褐色的柔毛；叶片如纸，呈三角状卵形，边缘呈波状。花果期5—6月。 因9世纪自西域传入中国，故名西瓜。",
    };

    public static List<Fruit> getDefaultList() {
        List<Fruit> list = new ArrayList<>();
        for (int i = 0; i < iconArray.length; i++) {
            list.add(new Fruit(iconArray[i], startArray[i]));
        }
        return list;
    }

    public static Map<String, String> getDescMap() {
        Map<String, String> map = new HashMap<>(descArray.length);
        for (int i = 0; i < descArray.length; i++) {
            map.put(startArray[i], descArray[i]);
        }
        return map;
    }
}
