package jp.ac.dendai.sie.usd.student.adapter.mappers;

import jp.ac.dendai.sie.usd.domain.model.User;
import jp.ac.dendai.sie.usd.student.model.request.UserInformationReq;
import jp.ac.dendai.sie.usd.student.model.response.UserInformationRes;

/**
 * Created by guest1 on 2018/10/25.
 */
public class UserInformationMapperImp implements UserInformationMapper {
    @Override
    public User toDomain(UserInformationReq userInformationReq) {
        return new User(userInformationReq.getUserId(), userInformationReq.getFirstName(), userInformationReq.getLastName());
    }

    @Override
    public UserInformationRes toRes(User user) {
        return new UserInformationRes(user.getUserId(), user.getFirstName(), user.getLastName());
    }
}
