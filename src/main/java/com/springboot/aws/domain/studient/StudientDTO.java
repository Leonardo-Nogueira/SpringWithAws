package com.springboot.aws.domain.studient;

public record StudientDTO(String name,
                          Integer age,
                          String email,
                          String phone,
                          String roomId) {
}
