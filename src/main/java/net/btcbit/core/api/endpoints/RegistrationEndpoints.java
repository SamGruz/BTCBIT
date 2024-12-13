package net.btcbit.core.api.endpoints;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RegistrationEndpoints {

    SIGN_UP("/sign_up/");

    private final String endpoint;
}
