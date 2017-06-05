package utils

import javax.inject.Inject

import play.filters.csrf.CSRFFilter

import play.api.http.HttpFilters

class Filters @Inject() (csrfFilter: CSRFFilter) extends HttpFilters {
  def filters = Seq(csrfFilter)
}