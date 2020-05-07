package jp.ac.dendai.sie.usd.teacher.usecase.presenter;

import jp.ac.dendai.sie.usd.domain.model.User;
import jp.ac.dendai.sie.usd.teacher.model.response.UserInformationRes;

import java.util.List;

public interface UserInformationPresenter {
    List<UserInformationRes> toUserInformationRes(List<User> userList);
}
