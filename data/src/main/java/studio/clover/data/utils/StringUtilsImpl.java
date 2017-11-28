package studio.clover.data.utils;

import clover.studio.domain.StringUtils;

public final class StringUtilsImpl implements StringUtils {

    @Override
    public boolean isEmpty(final String text) {
        return text == null || text.length() == 0;
    }
}
