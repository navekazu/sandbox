package tools.mybatis.sample.mapper;

import tools.mybatis.sample.domain.EnvInfo;

public interface EnvInfoMapper {
    public EnvInfo selectEnvInfo(int id);
    public String selectValue(int id);
}
