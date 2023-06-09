/*
package ru.yandex.practicum.catsgram.dao.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.yandex.practicum.catsgram.dao.FollowDao;
import ru.yandex.practicum.catsgram.dao.PostRepository;
import ru.yandex.practicum.catsgram.dao.UserDao;
import ru.yandex.practicum.catsgram.model.Post;
import ru.yandex.practicum.catsgram.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FollowDaoImpl implements FollowDao {

    private final JdbcTemplate jdbcTemplate;
    private final UserDao userDao;
    private final PostRepository postRepository;

    @Override
    public List<Post> getFollowFeed(String userId, int max) {
        // получаем все подписки пользователя
        */
/*String sql = "select * from cat_follow where follower_id = ?";
        List<Follow> follows = jdbcTemplate.query(sql, (rs, rowNum) -> makeFollow(rs), userId);

        // выгружаем авторов на которых подписан пользователь
        Set<User> authors = follows.stream()
                .map(Follow::getAuthor)
                .map(userDao::findUserById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());

        if(authors.isEmpty()) {
            return Collections.emptyList();
        }*//*


        //String sql = "select * from cat_post AS cp join cat_follow AS cf ON cp.author_id = cf.author_id where cf.follower_id = ?";

        String sql = "select cu.id, cu.username,cu.nickname from cat_user AS cu join cat_follow AS cf ON cu.id = cf.author_id where cf.follower_id = ?";
        List<User> authors = jdbcTemplate.query(sql, (rs, rowNum) -> makeFollow(rs), userId);

        // выгружаем посты полученных выше авторов
        return authors.stream()
                .map(postRepository::findPostsByUser)
                .flatMap(Collection::stream)
                // сортируем от новых к старым
                .sorted(Comparator.comparing(Post::getCreationDate).reversed())
                // отбрасываем лишнее
                .limit(max)
                .collect(Collectors.toList());
    }

    private User makeFollow(ResultSet rs) throws SQLException {
        return new User(rs.getString("id"), rs.getString("username"), rs.getString("nickname"));
        //return new Follow(rs.getString("author_id"), rs.getString("follower_id"));
    }
}*/
