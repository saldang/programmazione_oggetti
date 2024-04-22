---
layout: page
title: Slides
permalink: /slides/
---

## {{page.title}}

{% for folder in site.pages %}

- [{{folder.title}}]({{site.baseurl}}{{folder.url}})
  {% endfor %}
