---
layout: page
title: Slides
permalink: /slides/
---

## {{page.title}}

{% for folder in site.pages %}
{% if folder.dir contains slides %}

- [{{folder.title}}]({{site.baseurl}}{{folder.url}})
  {% endif %}
  {% endfor %}
