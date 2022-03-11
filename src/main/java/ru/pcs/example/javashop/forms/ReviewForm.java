package ru.pcs.example.javashop.forms;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ReviewForm {
    @NotNull
    private String name;
    @NotNull
    private String review;
}
