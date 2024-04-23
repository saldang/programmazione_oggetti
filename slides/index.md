---
layout: page
title: Slides
permalink: /slides/
---

## {{page.title}}

{% assign slides=site.static_files | where_exp:"slide","slide.path contains 'assets'" | sort_natural %}
{{ sortedSlides | inspect }}
{% for slide in sortedSlides %}

- [{{ slide.name }}]({{site.baseurl}}{{slide.path}})
  {% endfor %}
