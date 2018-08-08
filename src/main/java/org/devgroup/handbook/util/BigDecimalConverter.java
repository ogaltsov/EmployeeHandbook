package org.devgroup.handbook.util;

import javax.persistence.AttributeConverter;
import java.math.BigDecimal;

public class BigDecimalConverter implements AttributeConverter<BigDecimal,Long> {
    @Override
    public Long convertToDatabaseColumn(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return null;
        } else {
            return bigDecimal.multiply(BigDecimal.valueOf(100)).longValue();
        }
    }

    @Override
    public BigDecimal convertToEntityAttribute(Long aLong) {
        if (aLong == null) {
            return null;
        } else {
            return new BigDecimal(aLong).divide(BigDecimal.valueOf(100));
        }    }
}
