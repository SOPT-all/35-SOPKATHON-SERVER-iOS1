
package org.sopt.sopkathon.domain.problem.api.dto.request;
import java.util.List;

public class CreateProblemRequestDTO {

    private String title;
    private List<ItemRequestDTO> items;

    // Getter and Setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<ItemRequestDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemRequestDTO> items) {
        this.items = items;
    }

    // 내부 클래스: ItemRequestDTO
    public static class ItemRequestDTO {
        private String content; // Item의 내용

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}