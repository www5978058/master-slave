package com.shyb.masterslave.resolver;

import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wzh
 * @date 2019/6/6 - 13:59
 */
public class MyJavaTypeResolver extends JavaTypeResolverDefaultImpl {
    public MyJavaTypeResolver() {
        super();
        super.typeMap.put(-6, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("TINYINT", new FullyQualifiedJavaType(Integer.class.getName())));
        typeMap.put(Types.SMALLINT, new JdbcTypeInformation("SMALLINT", //$NON-NLS-1$
                new FullyQualifiedJavaType(Integer.class.getName())));

    }

}
