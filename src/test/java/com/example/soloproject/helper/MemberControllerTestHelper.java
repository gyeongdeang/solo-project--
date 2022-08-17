package com.example.soloproject.helper;

import java.net.URI;

public interface MemberControllerTestHelper extends ControllerTestHelper {
    String MEMBER_URL = "/v1/members";
    default URI getURI() {
        return createURI(MEMBER_URL);
    }

    default URI getURI(long memberId) {
        return createURI(MEMBER_URL + "/{memberId}", memberId);
    }
}
