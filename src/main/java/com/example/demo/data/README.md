# Implements

## ユーザー登録
1. insert User

## スケジュール作成
1. insert Schedule

## スケジュール登録
1. insert UserSchedule
2. loop
   1. insert UserPeriod

GraphQLのAPIを構築する際に、Lombokの`@Data`アノテーションを使用したクラスとJavaの`record`機能を組み合わせて使う方法はいくつかあります。これを実現するための具体的な方法について説明します。



例としてシンプルなエンティティを使用して説明します。



### 1. Lombokの@Dataアノテーションを使用したクラス



Lombokは、Javaのボイラープレートコードを減らすのに非常に便利なライブラリです。例えば、以下のようなエンティティクラスがあるとします。



```java

import lombok.Data;



@Data

public class User {

    private Long id;

    private String name;

    private String email;

}

```



### 2. GraphQL用のRecordクラス



GraphQLで上記のエンティティをやり取りするために、Recordクラスを使用することができます。JavaのRecordは不変データキャリアを簡単に作成するための構文糖衣です。



```java

public record UserDto(Long id, String name, String email) {}

```



### 3. 変換ロジックの実装



よくあるパターンとして、LombokのデータクラスからRecordクラスへの変換、またはその逆を行うための変換ロジックが必要です。これを実現する方法を以下に示します。



#### クラストゥレコードの変換



```java

public class UserMapper {

    public static UserDto toDto(User user) {

        if (user == null) {

            return null;

        }

        return new UserDto(user.getId(), user.getName(), user.getEmail());

    }



    public static User toEntity(UserDto userDto) {

        if (userDto == null) {

            return null;

        }

        User user = new User();

        user.setId(userDto.id());

        user.setName(userDto.name());

        user.setEmail(userDto.email());

        return user;

    }

}

```



### 4. サンプルGraphQLエンドポイント



例えば、Spring BootとGraphQLを使って簡単なエンドポイントを定義します。



```java

import org.springframework.graphql.data.method.annotation.QueryMapping;

import org.springframework.stereotype.Controller;



@Controller

public class UserController {

    @QueryMapping

    public UserDto getUser(Long id) {

        // 通常はサービスレイヤー経由でデータを取得する

        User user = userService.findById(id);

        

        // エンティティからDTOに変換して返す

        return UserMapper.toDto(user);

    }

}

```



### まとめ



要点としては、Lombokによって生成されたエンティティクラスと、GraphQL用のRecordを明確に分離し、それぞれの責任を持たせることです。エンティティクラスは内部的なデータ管理を行い、Recordクラスはデータの不変の表現としてGraphQLのインタフェースに渡すために使用します。



この手法は、データの完全性と一貫性を保ちながら、コードを清潔で理解しやすく保つのに役立ちます。