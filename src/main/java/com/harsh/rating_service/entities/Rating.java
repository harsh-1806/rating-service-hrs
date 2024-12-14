package com.harsh.rating_service.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Document("user_ratings")
public class Rating {

    @Id
    private String ratingId;
    @Indexed
    private String userId;
    @Indexed
    private String hotelId;
    private Integer rating;
    private String feedback;
}
