package jp.co.axiz.web.servlet.update;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import jp.co.axiz.web.entity.UserInfo;
import jp.co.axiz.web.service.UserInfoService;
import jp.co.axiz.web.servlet.SessionInfo;
import jp.co.axiz.web.util.ParamUtil;

/**
 * 更新画面用Servlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 文字化け対策
        request.setCharacterEncoding("UTF-8");
        
        // 入力値取得
        String loginId = request.getParameter("loginId");

        if (ParamUtil.isNullOrEmpty(loginId)) {
            request.setAttribute("idErrMsg", "IDは必須です");
            request.getRequestDispatcher("update.jsp").forward(request, response);
            return;
        }

        // ユーザ情報取得
        UserInfoService userInfoService = new UserInfoService();
        UserInfo userInfo = userInfoService.findByLoginId(loginId);

        if (userInfo == null) {
            // データが存在しない場合
            request.setAttribute("errMsg", "入力されたデータは存在しません");
            request.getRequestDispatcher("update.jsp").forward(request, response);
            return;
        }

        // 取得したデータをEntityへセット
        UserInfo updateUser = new UserInfo(
                userInfo.getUserId(),
                userInfo.getLoginId(),
                userInfo.getUserName(),
                userInfo.getTelephone(),
                userInfo.getPassword(),
                userInfo.getRoleId(),
                userInfo.getRoleName());

        // セッション情報取得
        HttpSession session = request.getSession();
        SessionInfo sessionInfo = ParamUtil.getSessionInfo(session);

        // 変更前のデータとしてセッションへ保存
        // (更新内容入力画面で、値が変更されたかを比較するために使用する)
        sessionInfo.setPrevUpdateUser(userInfo);

        // 変更後のデータとしてセッションへ保存
        // (更新内容入力画面で初期値セット及び、入力情報をセットするために使用する)
        sessionInfo.setUpdateUser(updateUser);

        request.getRequestDispatcher("updateInput.jsp").forward(request, response);
    }
}