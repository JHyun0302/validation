package hello.itemservice.domain.item;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
//@ScriptAssert(lang = "javascript", script = "_this.price * _this.quantity >= 10000", message = "총합이 10000원 넘게 입력해주세요.")
//ObjectError를 @로 처리 - 사용에 제약이 많음 -> 차라리 자바 코드로 작성하는 것을 권장!!
public class Item {
    @NotNull(groups = UpdateCheck.class) //수정 요구사항 추가(수정할 때만 체크)
    private Long id;
    @NotBlank(groups = {SaveCheck.class, UpdateCheck.class}, message = "공백X") //default message
    private String itemName;
    @NotNull(groups = {SaveCheck.class, UpdateCheck.class})
    @Range(min = 1000, max = 1000000)
    private Integer price;
    @NotNull(groups = {SaveCheck.class, UpdateCheck.class})
    @Max(value = 9999, groups = SaveCheck.class) //수정 요구사항 추가(저장할 때만 체크)
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
