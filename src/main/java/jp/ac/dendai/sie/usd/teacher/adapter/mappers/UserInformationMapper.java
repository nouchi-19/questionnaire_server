package jp.ac.dendai.sie.usd.teacher.adapter.mappers;

import jp.ac.dendai.sie.usd.domain.model.User;
import jp.ac.dendai.sie.usd.teacher.model.request.UserInformationReq;
import jp.ac.dendai.sie.usd.teacher.model.response.UserInformationRes;

/**
 * Created by guest1 on 2018/10/25.
 */
public interface UserInformationMapper {
    User toDomain(UserInformationReq userInformationReq);
    UserInformationRes toRes(User user);
}
