package jp.ac.dendai.sie.usd.teacher.adapter.presenters;

import jp.ac.dendai.sie.usd.domain.model.User;
import jp.ac.dendai.sie.usd.teacher.adapter.mappers.UserInformationMapper;
import jp.ac.dendai.sie.usd.teacher.model.response.UserInformationRes;
import jp.ac.dendai.sie.usd.teacher.usecase.presenter.UserInformationPresenter;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class UserInformationPresenterImp implements UserInformationPresenter {

    @Inject
    UserInformationMapper userInformationMapper;

    @Override
    public List<UserInformationRes> toUserInformationRes(List<User> userList) {
        return userList.stream().map(user -> userInformationMapper.toRes(user)).collect(Collectors.toList());
    }
}
