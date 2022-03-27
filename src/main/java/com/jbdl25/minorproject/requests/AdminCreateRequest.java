package com.jbdl25.minorproject.requests;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AdminCreateRequest {
    private String name;
    private String email;
    private String password;
}
