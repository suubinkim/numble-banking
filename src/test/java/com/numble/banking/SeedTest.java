package com.numble.banking;


import com.numble.banking.util.KISA_SEED_CBC;
import com.numble.banking.util.Seed;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class SeedTest {

    private final byte[] pbszUserKey = "testCrypt2020!@#".getBytes();
    private final byte[] pbszIV = "1234567890123456".getBytes();


    @Test
    public void seedTest() {
        // given
        String rawMessage = "테스트 데이터";
        log.info("원본 데이터 =>" + rawMessage);

        // when
        byte[] encryptedMessage = KISA_SEED_CBC.SEED_CBC_Encrypt(pbszUserKey, pbszIV, rawMessage.getBytes(), 0, rawMessage.getBytes().length);
        log.info("암호화된 데이터1 => " + new String(encryptedMessage));
        log.info("암호화된 데이터2 => " + encryptedMessage.toString());

        byte[] decryptedMessage = KISA_SEED_CBC.SEED_CBC_Decrypt(pbszUserKey, pbszIV, encryptedMessage, 0, encryptedMessage.length);
        log.info("복호화된 데이터 => " + new String(decryptedMessage));

        // then
        assertThat(rawMessage).isEqualTo(new String(decryptedMessage));
        assertThat(rawMessage).isNotEqualTo(encryptedMessage);
    }

    @Test
    public void SeedCustomTest() {
        // given
        String rawMessage = "테스트 데이터";
        log.info("원본 데이터 =>" + rawMessage);

        // when
        String encryptedMessage = Seed.encrypt(rawMessage);
        log.info("암호화 데이터 =>" + encryptedMessage);

        String decryptedMessage = Seed.decrypt(encryptedMessage);
        log.info("복호화 데이터 =>" + decryptedMessage);

        // then
        assertThat(rawMessage).isEqualTo(decryptedMessage);
        assertThat(rawMessage).isNotEqualTo(encryptedMessage);
    }
}
