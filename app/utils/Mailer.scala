package utils

import javax.inject.{ Inject, Singleton }
import models.User
import play.twirl.api.Html
import views.html.mails

@Singleton
class Mailer @Inject() (ms: MailService) {

  implicit def html2String(html: Html): String = html.toString

  def welcome(user: User, link: String) {
    ms.sendEmailAsync(user.email)(
      subject = "mail.welcome.subject",
      bodyHtml = mails.welcome(user.firstName, link),
      bodyText = mails.welcomeTxt(user.firstName, link)
    )
  }

  def forgotPassword(email: String, link: String) {
    ms.sendEmailAsync(email)(
      subject = "mail.forgotpwd.subject",
      bodyHtml = mails.forgotPassword(email, link),
      bodyText = mails.forgotPasswordTxt(email, link)
    )
  }

}