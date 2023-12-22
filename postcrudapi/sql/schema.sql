
create table comment (
                         comment_id bigint not null,
                         post_id bigint,
                         content varchar(255),
                         primary key (comment_id)
)
create table post (
                      post_id bigint not null,
                      content varchar(255),
                      title varchar(255),
                      primary key (post_id)
)