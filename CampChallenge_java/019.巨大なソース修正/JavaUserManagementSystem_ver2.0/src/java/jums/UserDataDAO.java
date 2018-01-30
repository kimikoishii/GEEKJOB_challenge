package jums;

import base.DBManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * ユーザー情報を格納するテーブルに対しての操作処理を包括する DB接続系はDBManagerクラスに一任 基本的にはやりたい1種類の動作に対して1メソッド
 *
 * @author hayashi-s
 */
public class UserDataDAO {

    //インスタンスオブジェクトを返却させてコードの簡略化
    public static UserDataDAO getInstance() {
        return new UserDataDAO();
    }

    /**
     * データの挿入処理を行う。現在時刻は挿入直前に生成
     *
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー
     */
    public void insert(UserDataDTO ud) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = DBManager.getConnection();
            st = con.prepareStatement("INSERT INTO user_t(name,birthday,tell,type,comment,newDate) VALUES(?,?,?,?,?,?)");
            st.setString(1, ud.getName());
            st.setDate(2, new java.sql.Date(ud.getBirthday().getTime()));//指定のタイムスタンプ値からSQL格納用のDATE型に変更
            st.setString(3, ud.getTell());
            st.setInt(4, ud.getType());
            st.setString(5, ud.getComment());
            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
            System.out.println("insert completed");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }

    }

    /**
     * データの検索処理を行う。
     *
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー
     * @return 検索結果
     */
    public ArrayList<UserDataDTO> search(UserDataDTO ud) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = DBManager.getConnection();

            /*下記は、いずれかのフォームの入力状況によってSQL文を変える処理*/
            
            //元のSQL文
            //何も入力されなければテーブル内を全て検索
            String sql = "SELECT * FROM user_t";
            
            //入力状況把握用の変数
            int flag = 0;
            
            //名前欄入力済み　flag+1
            //空ならなにもしない
            if (!ud.getName().equals("")) {
                sql += " WHERE name like ?";
                flag += 1;
            }
            
            //生年欄入力済み　flag+2
            //空なら flag+10
            if (ud.getBirthday() != null) {
                if (flag == 0) {
                    sql += " WHERE birthday like ?";
                    flag += 2;
                } else {
                    sql += " AND birthday like ?";
                    flag += 10;
                }
            }
            
            //種別欄入力済み　flag+3
            //空なら flag+20
            if (ud.getType() != 0) {
                if (flag == 0) {
                    sql += " WHERE type like ?";
                    flag += 3;
                } else {
                    sql += " AND type like ?";
                    flag += 20;
                }
            }
            
            //ここで基本のSQL文を確定
            st = con.prepareStatement(sql);
            
            //flagの合計値によって入力された欄を判断し、?に入力フォームの値を入れる
            switch (flag) {
                case 0://未入力
                    break;
                case 31://全部
                    st.setString(1, "%" + ud.getName() + "%");
                    st.setString(2, "%" + new SimpleDateFormat("yyyy").format(ud.getBirthday()) + "%");
                    st.setInt(3, ud.getType());
                    break;
                case 22://BirthとType
                    st.setString(1, "%" + new SimpleDateFormat("yyyy").format(ud.getBirthday()) + "%");
                    st.setInt(2, ud.getType());
                    break;
                case 21://NameとType
                    st.setString(1, "%" + ud.getName() + "%");
                    st.setInt(2, ud.getType());
                    break;
                case 11://NameとBirth
                    st.setString(1, "%" + ud.getName() + "%");
                    st.setString(2, "%" + new SimpleDateFormat("yyyy").format(ud.getBirthday()) + "%");
                    break;
                case 3://Type
                    st.setInt(1, ud.getType());
                    break;
                case 2://Birth
                    st.setString(1, "%" + new SimpleDateFormat("yyyy").format(ud.getBirthday()) + "%");
                    break;
                case 1://Name
                    st.setString(1, "%" + ud.getName() + "%");
                    break;
            }
            
            //検索
            ResultSet rs = st.executeQuery();
            
            //全ての検索結果をDTOにsetした状態でArrayListに入れる
            ArrayList<UserDataDTO> list = new ArrayList<UserDataDTO>();
            while (rs.next()) {
                UserDataDTO resultUd = new UserDataDTO();
                resultUd.setUserID(rs.getInt("userID"));
                resultUd.setName(rs.getString("name"));
                resultUd.setBirthday(rs.getDate("birthday"));
                resultUd.setTell(rs.getString("tell"));
                resultUd.setType(rs.getInt("type"));
                resultUd.setComment(rs.getString("comment"));
                resultUd.setNewDate(rs.getTimestamp("newDate"));
                list.add(resultUd);
            }
            System.out.println("search completed");
            
            //個人情報（DTOにset状態）の束をArrayListにて返却
            return list;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }

    }

    /**
     * ユーザーIDによる1件のデータの検索処理を行う。
     *
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー
     * @return 検索結果
     */
    public UserDataDTO searchByID(UserDataDTO ud) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = DBManager.getConnection();

            String sql = "SELECT * FROM user_t WHERE userID = ?";

            st = con.prepareStatement(sql);
            st.setInt(1, ud.getUserID());

            ResultSet rs = st.executeQuery();
            rs.next();
            UserDataDTO resultUd = new UserDataDTO();
            resultUd.setUserID(rs.getInt(1));
            resultUd.setName(rs.getString(2));
            resultUd.setBirthday(rs.getDate(3));
            resultUd.setTell(rs.getString(4));
            resultUd.setType(rs.getInt(5));
            resultUd.setComment(rs.getString(6));
            resultUd.setNewDate(rs.getTimestamp(7));

            System.out.println("searchByID completed");

            return resultUd;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }
            

    /**
     * 指定したuserIDをもつレコードの上書き処理を行う。
     *
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー
     */
    public void update(UserDataDTO ud) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = DBManager.getConnection();
            st = con.prepareStatement("UPDATE user_t SET name=?,birthday=?,tell=?,type=?,comment=?,newDate=? WHERE userID=?");
            st.setString(1, ud.getName());
            st.setDate(2, new java.sql.Date(ud.getBirthday().getTime()));//指定のタイムスタンプ値からSQL格納用のDATE型に変更
            st.setString(3, ud.getTell());
            st.setInt(4, ud.getType());
            st.setString(5, ud.getComment());
            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            st.setInt(7, ud.getUserID());
            st.executeUpdate();
            System.out.println("update completed");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }


/**
     * 指定したuserIDをもつレコードの削除を行う。
     *
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー
     */    
        public void delete(UserDataDTO ud) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = DBManager.getConnection();
            st = con.prepareStatement("DELETE FROM user_t WHERE userID=?");
            st.setInt(1, ud.getUserID());
            st.executeUpdate();
            System.out.println("delete completed");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    }
