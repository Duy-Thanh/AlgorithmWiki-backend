package com.algorithmswiki.apps.backend.backend;

import java.util.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class JWTTokenGenerator {
    public static String createJwtToken(String username, String password, String secretKey) throws Exception {
        Map<String, Object> header = new HashMap<>();
        header.put("alg", "HS512");
        header.put("typ", "JWT");
        String encodedHeader = Base64.getUrlEncoder().withoutPadding().encodeToString(header.toString().getBytes());

        // Step 2: Create the Payload
        Map<String, Object> payload = new HashMap<>();
        payload.put("sub", username);
        payload.put("iat", new Date().getTime());
        payload.put("exp", new Date().getTime() + 3600000); // 1 hour
        String encodedPayload = Base64.getUrlEncoder().withoutPadding().encodeToString(payload.toString().getBytes());

        // Step 3: Sign the Token
        String signature = createSignature(encodedHeader, encodedPayload, secretKey);

        // Step 4: Encode the Token
        return encodedHeader + "." + encodedPayload + "." + signature;
    }

    private static String createSignature(String encodedHeader, String encodedPayload, String secretKey) throws Exception {
        String message = encodedHeader + "." + encodedPayload;
        Mac sha512_HMAC = Mac.getInstance("HmacSHA512");
        SecretKeySpec secret_key = new SecretKeySpec(secretKey.getBytes(), "HmacSHA512");
        sha512_HMAC.init(secret_key);

        byte[] signatureBytes = sha512_HMAC.doFinal(message.getBytes());
        return Base64.getUrlEncoder().withoutPadding().encodeToString(signatureBytes);
    }
}
