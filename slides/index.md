---
layout: page
title: Slides
permalink: /slides/
---

## {{page.title}}

{% assign sortedSlides = site.static_files | sort: "name" %}
{{ sortedSlides | inspect }}
{% for slide in sortedSlides %}

- [{{ slide.name }}]({{site.baseurl}}{{slide.path}})
  {% endfor %}
