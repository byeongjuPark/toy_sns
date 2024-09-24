
CREATE TABLE account
(
  seq INTEGER      NOT NULL,
  id  VARCHAR(100) NULL    ,
  pw  VARCHAR(100) NULL    ,
  sex VARCHAR(100) NULL    ,
  PRIMARY KEY (seq)
);

CREATE TABLE board
(
  boardseq     INTEGER      NOT NULL,
  writer_seq   INTEGER      NOT NULL,
  content      VARCHAR(100) NULL    ,
  like_count   INTEGER      NULL    ,
  writer_date  VARCHAR(100) NULL    ,
  file_existed VARCHAR(100) NULL    ,
  PRIMARY KEY (boardseq)
);

CREATE TABLE board_file_attach
(
  boardseq           INTEGER      NOT NULL,
  original_file_name VARCHAR(100) NULL    ,
  file_path          VARCHAR(100) NULL    
);

ALTER TABLE board
  ADD CONSTRAINT FK_account_TO_board
    FOREIGN KEY (writer_seq)
    REFERENCES account (seq);

ALTER TABLE board_file_attach
  ADD CONSTRAINT FK_board_TO_board_file_attach
    FOREIGN KEY (boardseq)
    REFERENCES board (boardseq);
